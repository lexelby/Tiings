package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_31
   extends TilingType
{
   public TilingTypeNC6_31(){
      super( "NC6-31", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{240};
      paramDef = new int[]{144};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,5, 1,1,2, 0},
            {0, 0,1, 2,0,1, 1},

            {0, 5,4, 0,4,5, 0},
            {1, 0,1, 4,0,1, 1},
            {1, 4,5, 5,1,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e=f\nC=E\nE+F=360\n2B+C=360\n(A+D=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double c = getParam(paramValues, 0);
      double h = calcSide(ln,ln,c);
      double diag = calcSide(ln,2*ln,c);
      double ln2 = Math.sqrt(diag*diag-h*h);
      double angEAF = calcAngle(diag,2*ln,ln);
      double a = Math.asin(h/diag)/DEG2RAD + ( c<180 ? - angEAF : angEAF);
      
      double c1 = ln * Math.cos( a * DEG2RAD );
      double s1 = ln * Math.sin( a * DEG2RAD );
      double c2 = ln * Math.cos( c/2 * DEG2RAD );
      double s2 = ln * Math.sin( c/2 * DEG2RAD );
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,  ln2,  0);
      baseTile.setPoint(2,  ln2+c2,  s2);
      baseTile.setPoint(3,  ln2,  h);
      baseTile.setPoint(4,  ln2-c1,  h-s1);
      baseTile.setPoint(5,  c1, s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(5)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(5)-tiles[7].getY(4);
   }
}