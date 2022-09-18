package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_53b
   extends TilingType
{
   public TilingTypeNC5_53b(){
      super( "NC5-53b", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0,  0,  0 };
      paramMax = new int[]{ 180,100,100,100 };
      paramDef = new int[]{  50, 60, 50, 50 };
      paramName = new String[]{ "Angle", "Skew", "Length", "Indentation" };
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 4,3, 2,3,4, 0},
            {1, 0,4, 0,2,1, 1},
            {0, 4,3, 4,3,4, 1},
            {1, 2,1, 4,1,2, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "a=c+d\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double anAOB = paramValues[0];
      double lnBC = paramValues[2]/100.;
      double lnAE = lnBC;
      double lnOA = lnAE + (2-lnBC-lnAE) * paramValues[1]/100.;
      double lnOB = 2-lnOA;
      double lnAB = calcSide(lnOA, lnOB, anAOB);
      double anEAB = calcAngle(lnOA, lnAB, lnOB);
      double anABC = 180-anEAB-anAOB;

      double maxindent =  Math.sin(anABC*DEG2RAD) * lnBC / Math.sin(anEAB*DEG2RAD);
      double lnCD = maxindent*paramValues[3]/100.;
      lnAE += lnCD;

      double f = 3/(lnAE+lnAB+lnBC);
      lnAE *=f;
      lnAB *=f;
      lnBC *=f;
      lnCD *=f;
      
      double xA = 0;
      double yA = 0;
      double xB = lnAB * Math.cos( (90-anAOB/2-anEAB) * DEG2RAD);
      double yB = lnAB * Math.sin( (90-anAOB/2-anEAB) * DEG2RAD);
      double xC = xB + lnBC * Math.cos( (90+anAOB/2) * DEG2RAD);
      double yC = yB + lnBC * Math.sin( (90+anAOB/2) * DEG2RAD);
      double xD = xC - lnCD * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yD = yC - lnCD * Math.sin( (90-anAOB/2) * DEG2RAD);
      double xE = lnAE * Math.cos( (90-anAOB/2) * DEG2RAD);
      double yE = lnAE * Math.sin( (90-anAOB/2) * DEG2RAD);

      baseTile.setPoint(0, xA, yA);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(0)-tiles[1].getY(1);
      offsets[2] = tiles[7].getX(2)-tiles[2].getX(0);
      offsets[3] = tiles[7].getY(2)-tiles[2].getY(0);
   }
}
