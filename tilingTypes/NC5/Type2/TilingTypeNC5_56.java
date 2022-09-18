package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_56
   extends TilingType
{
   public TilingTypeNC5_56(){
      super( "NC5-56", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 75};
      paramName = new String[]{ "Relative Length" , "Base"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,1,2, 0},
            {1, 3,2, 0,0,4, 1},
            {0, 1,2, 2,0,4, 1},
            {1, 1,2, 3,2,3, 0},
            {0, 1,2, 4,0,4, 0},
            {1, 3,2, 5,0,4, 1},
            {0, 1,2, 6,0,4, 1},
      };
      info = "a=c=d\nA+B=180\nA+D=360\n(B+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5 * getParam( paramValues,0)/100.;
      double ln2 = 1.5 - ln1;
      double minbase = Math.max(ln2,ln1-ln2);
      double maxbase = ln1+ln2;
      double ln3 = minbase + (maxbase-minbase) * paramValues[1]/100;
      double anA = calcAngle(ln1,ln2, ln3);
      double anE2 = calcAngle(ln2,ln3, ln1); 

      double xB = ln3;
      double yB = 0;
      double xE = ln1 * Math.cos( anA * DEG2RAD);
      double yE = ln1 * Math.sin( anA * DEG2RAD);
      double xC = xB + xE;
      double yC = yB + yE;
      double xD = xE + ln2 * Math.cos( anE2 * DEG2RAD);
      double yD = yE - ln2 * Math.sin( anE2 * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[3].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[3].getY(0);
      offsets[2] = tiles[6].getX(1)-tiles[0].getX(2);
      offsets[3] = tiles[6].getY(1)-tiles[0].getY(2);
   }
}
