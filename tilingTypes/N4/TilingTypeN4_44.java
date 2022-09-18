package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_44
   extends TilingType
{
   public TilingTypeN4_44(){
      super( "N4-44", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {1, 2,3, 1,3,2, 1},
            {0, 0,3, 2,0,3, 0},
            
            {0, 2,1, 0,1,0, 1},
            {1, 0,3, 4,0,3, 0},
            {1, 2,3, 5,3,2, 0},
            {0, 0,3, 6,0,3, 1},
      };
      info = "2b=c\nA=90\n2B+C=360\n(B-D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double c = Math.cos(an/2 * DEG2RAD);
      double s = Math.sin(an/2 * DEG2RAD);
      double w = 1 + 2*c;
      double h = w*s/c + 2*s;
      double ln = 1.5 / (h+w);
      w *= ln;
      h *= ln;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2,  w,  ln*2*s);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(2);
   }

}
