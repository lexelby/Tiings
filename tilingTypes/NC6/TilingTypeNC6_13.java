package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_13
   extends TilingType
{
   public TilingTypeNC6_13(){
      super( "NC6-13", 6, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{300};
      paramDef = new int[]{240};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,2,3, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 2,3, 2,0,5, 0},

            {0, 0,1, 2,0,1, 1},
            {1, 0,5, 4,2,3, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 2,3, 6,0,5, 1},
      };
      info = "a=c=d=e=f\nA=B\nD+E=360\nC+D+F=360\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0)/2;
      
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      double diag = calcSide(ln, ln/2, a*2);
      double ln2 = 2*(diag+c);
 
      double b = calcAngle(diag, ln, ln/2);
      if( a>90 ) b=-b;
      double c2 = ln * Math.cos( b * DEG2RAD );
      double s2 = ln * Math.sin( b * DEG2RAD );

      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,   ln2,     0);
      baseTile.setPoint(2, ln2-c,     s);
      baseTile.setPoint(3, ln2-c-c2,  s+s2);
      baseTile.setPoint(4,   c+c2,    s-s2);
      baseTile.setPoint(5,     c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[4].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[4].getY(4);
      offsets[2] = tiles[3].getX(5)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(5)-tiles[0].getY(0);
   }
}